C/C++ unit test newcode using [Google Test](https://code.google.com/p/googletest) deployed to

```bash
mkdir build
cd build
cmake ..
cmake --build .
```


## Running the tests

Either using `ctest`:
```
$ ctest

Running tests...
Test project /home/user/gtest-demo/build
    Start 1: unit
1/1 Test #1: unit .............................   Passed    0.00 sec

100% tests passed, 0 tests failed out of 1

Total Test time (real) =   0.00 sec
```

Or directly using `unit_tests`:
```
$ ./bin/unit_tests

[==========] Running 2 tests from 1 test case.
[----------] Global test environment set-up.
[----------] 2 tests from example
[ RUN      ] example.add
[       OK ] example.add (0 ms)
[ RUN      ] example.subtract
[       OK ] example.subtract (0 ms)
[----------] 2 tests from example (1 ms total)

[----------] Global test environment tear-down
[==========] 2 tests from 1 test case ran. (1 ms total)
[  PASSED  ] 2 tests.

```



add unittests in tests dir, 

then add the .cpp file to the tests/CMakeLists.txt

difference with c++, you need to add extern "C" {
#include "add.h"
} when you include the c header file.
