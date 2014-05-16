#include "stdafx.h"
#include "CppUnitTest.h"
#include "targetver.h"
#include <stdio.h>
#include <tchar.h>
#include <iostream>
using namespace std;

#include "SimpeMath.h"
#include "SimpeMath.cpp"

using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace UnitTest1{		
	TEST_CLASS(UnitTest1) {
	public:
		
		TEST_METHOD(TestSum){
			SimpeMath sm;
			int result = sm.sum(0, 1);
			Assert::AreEqual(1, result);
		}

		TEST_METHOD(TestSumZeros) {
			SimpeMath sm;
			int result = sm.sum(0, 0);
			Assert::AreEqual(0, result);
		}

	};
}