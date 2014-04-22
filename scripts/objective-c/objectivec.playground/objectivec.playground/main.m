//
//  main.m
//  objectivec.playground
//
//  Created by Dev on 4/14/14.
//  Copyright (c) 2014 Dev. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Person.h"
#import "BasicMath.h"
#import "BasicOC.h"
#import "DataTypes.h"
#import "ClosurePlay.h"
#import "OOAdvanced.h"
//#import "FPFun.h"

int main(int argc, const char * argv[]){
    @autoreleasepool {
        
        BasicMath *math = [[BasicMath alloc] init];
        [math doItAll];
        
        Person *diego = [[Person alloc] init];
        [diego doItAll];
        
        BasicOC *bc = [[BasicOC alloc] init];
        [bc doBasicStuff];
        
        DataTypes *dt = [[DataTypes alloc] init];
        [dt doItAll];
        
        ClosurePlay *cp = [[ClosurePlay alloc] init];
        [cp doItAll];
        
        OOAdvanced *ooa = [[OOAdvanced alloc] init];
        [ooa doItAll];
        
//        FPFun *fp = [[FPFun alloc] init];
//        [fp doFunFP];
        
    }
    return 0;
}