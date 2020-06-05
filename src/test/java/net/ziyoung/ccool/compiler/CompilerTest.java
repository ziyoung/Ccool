package net.ziyoung.ccool.compiler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
