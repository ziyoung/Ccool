package net.ziyoung.ccool.compiler;

import net.ziyoung.ccool.ast.CompilationUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompilerTest {

    @Test
    @DisplayName("compiler success")
    void compileFile() {
        Compiler compiler = new Compiler("src/test/resources/1-hello-world.ccool");
        CompilationUnit compilationUnit = assertDoesNotThrow(compiler::compile);
        assertNotNull(compilationUnit);
        assertTrue(compiler.parseSuccess());
    }
}
