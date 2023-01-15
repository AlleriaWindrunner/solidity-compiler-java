package org.blockchain.solc.compiler.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.blockchain.solc.compiler.CompilationResult;
import org.blockchain.solc.compiler.SolidityCompiler;
import org.junit.Test;

public class SolidityCompilerTest {
    @SuppressWarnings("static-access")
    @Test
    public void ecdsasolidityCompilerTest() {
        try {
            URL url =
                    SolidityCompilerTest.class
                            .getClassLoader()
                            .getSystemResource("solidity/Asset.sol");
            File file = new File(url.getFile());
            SolidityCompiler.Result result =
                    SolidityCompiler.compile(file, false, true, SolidityCompiler.Options.ABI, SolidityCompiler.Options.BIN, SolidityCompiler.Options.INTERFACE, SolidityCompiler.Options.METADATA);
            assertTrue(
                    "compile solidity failed, solidity error: " + result.getErrors(),
                    !result.isFailed());
            CompilationResult compilationResult = CompilationResult.parse(result.getOutput());
            CompilationResult.ContractMetadata contractMetadata =
                    compilationResult.getContract("Asset");
            assertTrue(
                    "BIN empty, compile error: " + result.getErrors(),
                    !("".equals(contractMetadata.bin)));
            assertTrue(
                    "ABI empty, compile error: " + result.getErrors(),
                    !("".equals(contractMetadata.abi)));
        } catch (IOException e) {
            assertTrue("compile solidity failed, error: " + e.getMessage(), false);
        }
    }

    @Test
    public void smSolidityCompilerTest() {
        try {
            URL url =
                    SolidityCompilerTest.class
                            .getClassLoader()
                            .getSystemResource("solidity/Asset.sol");
            File file = new File(url.getFile());
            SolidityCompiler.Result result =
                    SolidityCompiler.compile(file, true, true, SolidityCompiler.Options.ABI, SolidityCompiler.Options.BIN, SolidityCompiler.Options.INTERFACE, SolidityCompiler.Options.METADATA);
            assertTrue(
                    "compile solidity failed, solidity error: " + result.getErrors(),
                    !result.isFailed());
            CompilationResult compilationResult = CompilationResult.parse(result.getOutput());
            CompilationResult.ContractMetadata assetContractMetadata =
                    compilationResult.getContract("Asset");
            assertTrue(
                    "BIN empty, compile error: " + result.getErrors(),
                    !("".equals(assetContractMetadata.bin)));
            assertTrue(
                    "ABI empty, compile error: " + result.getErrors(),
                    !("".equals(assetContractMetadata.abi)));
        } catch (IOException e) {
            assertTrue("compile solidity failed, error: " + e.getMessage(), false);
        }
    }
}
