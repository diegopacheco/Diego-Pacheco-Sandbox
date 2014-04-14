//
//  main.m
//  objectivec_cli_playground
//
//  Created by Dev on 4/11/14.
//  Copyright (c) 2014 Dev. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Person.h"
#import "BasicMath.h"

int main(int argc, const char * argv[]){
   // @autoreleasepool {
        
      //  BasicMath *bm = [[BasicMath alloc] init];
      //  NSLog(@"POw: %@", [bm pow:[NSNumber numberWithInt 10]]);
    
    NSLog(@"FODA-SE");
    
        Person *diego = [[Person alloc] init];
        
        [diego setName: @"Diego"];
        NSLog(@"Created a %@", [diego name]);
        
        diego.name = @"Diego Pacheco";
        NSLog(@"Changed the PERSON to a %@", diego.name);
        
        [diego sayHi];
    
   // }
    return 0;
}

