#include "gtest/gtest.h"

extern "C" {
#include "add.h"
}

using namespace testing;

    TEST(Exp2Test, add)
    {
        int res;
        res = add(1, 2);
        EXPECT_EQ(res, 3);
    }

