package net.ziyoung.ccool.compiler;

import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.error.SemanticError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompilerTest {
    @Test
    @DisplayName("compile success")
    void compileFile() {
        Compiler compiler = new Compiler("src/test/resources/hello-world.ccool");
        assertDoesNotThrow(compiler::compile);
        assertNotNull(compiler.getCompilationUnit());
        assertTrue(compiler.parseSuccess());
        assertTrue(compiler.compileSuccess());
    }

    @Test
    @DisplayName("pre analyse fails")
    void doPreAnalyse() {
        Compiler compiler = new Compiler("src/test/resources/pre-analyse-fail.ccool");
        CompilationUnit compilationUnit = assertDoesNotThrow(compiler::parse);
        compiler.setCompilationUnit(compilationUnit);
        compiler.preAnalyse();
        compiler.report();
        assertFalse(compiler.compileSuccess());

        String[] messages = new String[]{
                "type t0 is not defined",
                "type t1 is not defined",
                "parameter v0 has been defined"
        };
        checkErrorMessages(messages, compiler.errors());
    }

    @Test
    @DisplayName("analyse fails")
    void doAnalyse() {
        Compiler compiler = new Compiler("src/test/resources/analyse-fail.ccool");
        CompilationUnit compilationUnit = assertDoesNotThrow(compiler::parse);
        compiler.setCompilationUnit(compilationUnit);
        compiler.preAnalyse();
        compiler.analyse();
        compiler.report();
        assertFalse(compiler.compileSuccess());

        String printMessage = "print's argument 0 expected primary-type";
        String[] messages = new String[]{
                "variable j is not defined",
                printMessage,
                "variable v1 is not defined",
                printMessage
        };
        checkErrorMessages(messages, compiler.errors());
    }

    private static void checkErrorMessages(String[] messages, List<SemanticError> errors) {
        assertEquals(messages.length, errors.size());
        for (int i = 0; i < messages.length; i++) {
            assertNotNull(errors.get(i));
            assertTrue(errors.get(i).toString().contains(messages[i]));
        }
    }
}
