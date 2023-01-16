# solidity-compiler-java

>solidity-compiler-java提供了Java编译solidity合约文件的接口，solidity编译器solc可以参考:https://github.com/ethereum/solidity。

# 支持平台

* linux
    * x64
    * aarch64
* mac
* windows

# 支持版本
>solidity-compiler-java支持三个版本的solidity编译器版本：

* 0.4.25.3
* 0.5.2.3
* 0.6.10.3
* 0.8.11.1

# 使用指南

## 依赖引用

### Gradle

#### 0.4.25.3 版本

```gradle
compile group: 'org.blockchain', name: 'solidity-compiler-java', version: '0.4.25.3'
```

#### 0.5.2.3 版本
```gradle
compile group: 'org.blockchain', name: 'solidity-compiler-java', version: '0.5.2.3'
```

#### 0.6.10.3 版本
```gradle
compile group: 'org.blockchain', name: 'solidity-compiler-java', version: '0.6.10.3'
```

#### 0.8.11.1 版本
```gradle
compile group: 'org.blockchain', name: 'solidity-compiler-java', version: '0.8.11.1'
```

### maven

#### 0.4.25.3

```xml
<dependency>
    <groupId>org.blockchain</groupId>
    <artifactId>solidity-compiler-java</artifactId>
    <version>0.4.25.3</version>
</dependency>
```

#### 0.5.2.3

```xml
<dependency>
    <groupId>org.blockchain</groupId>
    <artifactId>solidity-compiler-java</artifactId>
    <version>0.5.2.3</version>
</dependency>
```

#### 0.6.10.3

```xml
<dependency>
    <groupId>org.blockchain</groupId>
    <artifactId>solidity-compiler-java</artifactId>
    <version>0.6.10.3</version>
</dependency>
```

#### 0.8.11.1

```xml
<dependency>
    <groupId>org.blockchain</groupId>
    <artifactId>solidity-compiler-java</artifactId>
    <version>0.8.11.1</version>
</dependency>
```

## 核心接口

### 编译

```java
public static Result SolidityCompiler::compile(File source, boolean sm, boolean combinedJson, Option... options)
        throws IOException;
public static Result SolidityCompiler::compile(byte[] source, boolean sm, boolean combinedJson, Option... options)
        throws IOExceptio;
```

#### 请求参数

* File source : solidity文件文件路径
* byte[] resource : solidity文件内容
* boolean sm: 国密开关
* combinedJson:
* Option ... options: solc编译参数
    * Options.ABI: 相当于solc --abi
    * Options.BIN: 相当于solc --bin
    * Options.INTERFACE: 相当于solc --interface
    * Options.METADATA: 相当于solc --metadata
    * Options.ASTJSON: 相当于solc --ast-json

#### 响应参数

* SolidityCompiler::Result对象
    * boolean success: 是否编译成功
    * String errors: 错误或者警告信息，编译失败时保存错误信息，编译成功时保存编译的警告信息
    * String output: 编译结果，具体格式参考solc的返回格式

### 编译结果解析

```java
public static CompilationResult CompilationResult::parse(String rawJson) throws IOException 
```

#### 请求参数

* String rawJson: Result.getOutput的值

#### 响应参数

* CompilationResult对象
    * Map<String, ContractMetadata> contracts: 合约文件所有合约的编译结果

## 示例

```java
File socFile = new File("HelloWorld.sol");
SolidityCompiler.Result res = SolidityCompiler.compile(solFile, false, true, ABI, BIN, INTERFACE, METADATA);

if (!res.isFailed())) {
    // 编译成功，解析返回
    CompilationResult result = CompilationResult.parse(res.getOutput());
    // 获取HelloWorld合约的编译结果
    CompilationResult.ContractMetadata meta = result.getContract(“HelloWorld”);
    // abi
    String abi = meta.abi;
    // bin
    String bin = meta.bin;
    // 其他逻辑
} else {
    // 编译失败，res.getError()保存编译失败的原因
}
```