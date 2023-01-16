package org.blockchain.solc.compiler.test;

import java.io.IOException;
import org.blockchain.solc.compiler.SolidityCompiler;
import org.junit.Assert;
import org.junit.Test;

public class SolcTest {

    @Test
    public void smSolcTest() throws IOException {
        String versionOutput = SolidityCompiler.runGetVersionOutput(true);
        Assert.assertTrue(versionOutput.contains("0.5.2"));
        Assert.assertTrue(versionOutput.toLowerCase().contains("gm"));
    }

    @Test
    public void ecdsaSolcTest() throws IOException {
        String versionOutput = SolidityCompiler.runGetVersionOutput(false);
        Assert.assertTrue(versionOutput.contains("0.5.2"));
        Assert.assertTrue(!versionOutput.toLowerCase().contains("gm"));
    }
}
