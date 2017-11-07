#include "redismodule.h"

char * getDate() {
    time_t t = time(NULL);
    struct tm *tm = localtime(&t);
    char s[64];
    strftime(s, sizeof(s), "%c", tm);
    return strdup(s);
}

static int diegoDate_RedisCommand(RedisModuleCtx *ctx, RedisModuleString **argv, int argc) {
    RedisModule_AutoMemory(ctx);
    RedisModule_ReplicateVerbatim(ctx);

    RedisModule_ReplyWithSimpleString(ctx, getDate());
    return REDISMODULE_OK;
}

int RedisModule_OnLoad(RedisModuleCtx *ctx, RedisModuleString **argv, int argc) {

    if (RedisModule_Init(ctx, "dp", 1, 1) != REDISMODULE_OK) {
       printf("\n\r****** Init Fail!\n\r\n\r");
       return REDISMODULE_ERR;
    }

    if (RedisModule_CreateCommand(ctx, "dp.DATE",diegoDate_RedisCommand,"", 1,1,1) != REDISMODULE_OK){
       printf("\n\r****** Command Fail!\n\r\n\r");
       return REDISMODULE_ERR;
    }

    return REDISMODULE_OK;
}
