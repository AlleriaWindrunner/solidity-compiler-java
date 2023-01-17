package io.github.alleriawindrunner.solc.compiler.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import io.github.alleriawindrunner.solc.compiler.CompilationResult;
import io.github.alleriawindrunner.solc.compiler.SolidityCompiler;
import org.junit.Test;

public class SolidityCompilerTest {
    @SuppressWarnings("static-access")
    @Test
    public void ecdsasolidityCompilerTest() {
        try {
            URL url =
                    SolidityCompilerTest.class
                            .getClassLoader()
                            .getSystemResource("contracts/CharitySplitterFactory.sol");
            File file = new File(url.getFile());
            SolidityCompiler.Result result = SolidityCompiler.compile(file, false, true, SolidityCompiler.Options.ABI, SolidityCompiler.Options.BIN, SolidityCompiler.Options.METADATA);
            assertTrue(
                    "compile solidity failed, solidity error: " + result.getErrors(),
                    !result.isFailed());
            CompilationResult compilationResult = CompilationResult.parse(result.getOutput());
            CompilationResult.ContractMetadata contractMetadata =
                    compilationResult.getContract("CharitySplitter");
            assertTrue(
                    "BIN empty, compile error: " + result.getErrors(),
                    !("".equals(contractMetadata.bin)));
            assertTrue(
                    "ABI empty, compile error: " + result.getErrors(),
                    !("".equals(contractMetadata.abi)));

            CompilationResult.ContractMetadata assetContractMetadata0 =
                    compilationResult.getContract("CharitySplitterFactory");
            assertTrue(
                    "BIN empty, compile error: " + result.getErrors(),
                    !("".equals(assetContractMetadata0.bin)));
            assertTrue(
                    "ABI empty, compile error: " + result.getErrors(),
                    !("".equals(assetContractMetadata0.abi)));
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
                            .getSystemResource("contracts/CharitySplitterFactory.sol");
            File file = new File(url.getFile());
            SolidityCompiler.Result result = SolidityCompiler.compile(file, true, true, SolidityCompiler.Options.ABI, SolidityCompiler.Options.BIN, SolidityCompiler.Options.METADATA);
            assertTrue(
                    "compile solidity failed, solidity error: " + result.getErrors(),
                    !result.isFailed());
            CompilationResult compilationResult = CompilationResult.parse(result.getOutput());
            CompilationResult.ContractMetadata assetContractMetadata =
                    compilationResult.getContract("CharitySplitter");
            assertTrue(
                    "BIN empty, compile error: " + result.getErrors(),
                    !("".equals(assetContractMetadata.bin)));
            assertTrue(
                    "ABI empty, compile error: " + result.getErrors(),
                    !("".equals(assetContractMetadata.abi)));

            CompilationResult.ContractMetadata assetContractMetadata0 =
                    compilationResult.getContract("CharitySplitterFactory");
            assertTrue(
                    "BIN empty, compile error: " + result.getErrors(),
                    !("".equals(assetContractMetadata0.bin)));
            assertTrue(
                    "ABI empty, compile error: " + result.getErrors(),
                    !("".equals(assetContractMetadata0.abi)));
        } catch (IOException e) {
            assertTrue("compile solidity failed, error: " + e.getMessage(), false);
        }
    }
}
