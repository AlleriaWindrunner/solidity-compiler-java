package io.github.alleriawindrunner.solc.compiler.test;

import java.io.IOException;

import io.github.alleriawindrunner.solc.compiler.SolidityCompiler;
import org.junit.Assert;
import org.junit.Test;

public class SolcTest {

    @Test
    public void smSolcTest() throws IOException {
        String versionOutput = SolidityCompiler.runGetVersionOutput(true);
        Assert.assertTrue(versionOutput.contains("0.4.25"));
        Assert.assertTrue(versionOutput.toLowerCase().contains("gm"));
    }

    @Test
    public void ecdsaSolcTest() throws IOException {
        String versionOutput = SolidityCompiler.runGetVersionOutput(false);
        Assert.assertTrue(versionOutput.contains("0.4.25"));
        Assert.assertTrue(!versionOutput.toLowerCase().contains("gm"));
    }
}
