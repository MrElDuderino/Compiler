# Compiler of simple imperative language

Program translates programs written in simple imperative language into machine code for provided virtual machine.


## Build

```shell script
make
```

## Build virtual machine

```shell script
cd vm && make
```

## Compile program

```shell script
./compiler.sh <input_path> <output>
```

## Run compiled program

```shell script
./vm/maszyna-wirtualna <input_path>
```

## Dependencies

* openjdk version "11.0.5" 2019-10-15
* Gradle 6.1
* antlr4:4.7.2
