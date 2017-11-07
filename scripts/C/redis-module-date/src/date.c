#include "redismodule.h"

char* getDate() {
    time_t t = time(NULL);
    struct tm *tm = localtime(&t);
    //char s[64];
    char *s = (char *) malloc(sizeof(char) * 64);
    strftime(s, sizeof(s), "%c", tm);
    return s;
}

static int diegoDate_RedisCommand(RedisModuleCtx *ctx, RedisModuleString **argv, int argc) {
    RedisModule_AutoMemory(ctx);
    RedisModule_ReplicateVerbatim(ctx);

    RedisModule_ReplyWithSimpleString(ctx, "OK");
    return REDISMODULE_OK;
}

int RedisModule_OnLoad(RedisModuleCtx *ctx, RedisModuleString **argv, int argc) {

    if (RedisModule_Init(ctx, "dp", 1, 1) != REDISMODULE_OK) {
       return REDISMODULE_ERR;
    }

    if (RedisModule_CreateCommand(ctx, "dp.DATE",
    diegoDate_RedisCommand,"current Date", 1,1,1) != REDISMODULE_OK)
        return REDISMODULE_ERR;

    return REDISMODULE_OK;
}
