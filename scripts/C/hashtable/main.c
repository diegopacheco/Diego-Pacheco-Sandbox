#include <stdio.h>
#include "hash_table.c"

int main() {
    ht_hash_table* ht = ht_new();
    printf("count: %d size: %d",ht->count,ht->size);
    ht_del_hash_table(ht);
    ht_new_item("k1","v1");
}
