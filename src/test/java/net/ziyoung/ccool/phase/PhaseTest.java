package net.ziyoung.ccool.phase;

import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.error.SemanticError;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.parser.CcoolLangParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhaseTest {
    // FIXME: we need provide a service for recording errors.
    @BeforeEach
    public void startRecordErrors() {
        SemanticErrors.startRecord();
    }

    @Test
    @DisplayName("pre analyse fails")
    void preAnalyse() {
        CompilationUnit compilationUnit = assertDoesNotThrow(() -> parse("src/test/resources/pre-analyse-fail.ccool"));
        doPreAnalyse(compilationUnit);
        List<SemanticError> errors = SemanticErrors.getErrors();
        SemanticErrors.report();

        String[] messages = new String[]{
                "type t0 is not defined",
                "type t1 is not defined",
                "parameter v0 has been defined"
        };
        checkErrorMessages(messages, errors);
    }

    @Test
    @DisplayName("analyse fails")
    void analyse() {
        CompilationUnit compilationUnit = assertDoesNotThrow(() -> parse("src/test/resources/analyse-fail.ccool"));
        doAnalyse(compilationUnit);
        SemanticErrors.report();
        List<SemanticError> errors = SemanticErrors.getErrors();

        String printMessage = "print's argument 0 expected primary-type";
        String[] messages = new String[]{
                "variable j is not defined",
                printMessage,
                "variable v1 is not defined",
                printMessage
        };
        checkErrorMessages(messages, errors);
    }

    @Test
    @DisplayName("analyse stack size and local variables size")
    void analyseMethodMaxs() {
        CompilationUnit compilationUnit = assertDoesNotThrow(() -> parse("src/test/resources/locals-size.ccool"));
        AnalysePhase analysePhase = doAnalyse(compilationUnit);

        int stackSize = analysePhase.getStackSize();
        assertEquals(stackSize, 3);

        int localsSize = analysePhase.getLocalsSize();
        // 6 local variables, contain 1 double value.
        assertEquals(localsSize, 7);
    }

    public CompilationUnit parse(String fileName) throws IOException {
        CcoolLangParser parser = new CcoolLangParser(fileName);
        return parser.parse();
    }

    private void doPreAnalyse(CompilationUnit compilationUnit) {
        PreAnalysePhase preAnalysePhase = new PreAnalysePhase();
        preAnalysePhase.visitCompilationUnit(compilationUnit, null);
    }

    private AnalysePhase doAnalyse(CompilationUnit compilationUnit) {
        // Before AnalysePhase starts, we must call preAnalyse().
        // TODO: maybe we need dependency injection.
        doPreAnalyse(compilationUnit);
        AnalysePhase analysePhase = new AnalysePhase();
        analysePhase.visitCompilationUnit(compilationUnit, null);
        return analysePhase;
    }

    private static void checkErrorMessages(String[] messages, List<SemanticError> errors) {
        assertEquals(messages.length, errors.size());
        for (int i = 0; i < messages.length; i++) {
            assertNotNull(errors.get(i));
            assertTrue(errors.get(i).toString().contains(messages[i]));
        }
    }
}