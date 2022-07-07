<script>
export default {
  // reactive state
  data() {
    return {
      count: 0
    }
  },

  // functions that mutate state and trigger updates
  methods: {
    increment() {
      this.count++
    }
  },

  // lifecycle hooks
  mounted() {
    console.log(`The initial count is ${this.count}.`)
  }
}
</script>

<template>
  <button @click="increment">Count is: {{ count }}</button>
</template>