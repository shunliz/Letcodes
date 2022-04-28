#include "gtest/gtest.h"
#include "add.h"

    TEST(Exp2Test, add)
    {
        int res;
        res = add(1, 2);
        EXPECT_EQ(res, 3);
    }

