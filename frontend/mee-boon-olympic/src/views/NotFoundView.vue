<script setup lang="ts">
import { defineProps, withDefaults } from 'vue';

const props = withDefaults(
  defineProps<{
    resource: string;
  }>(),
  {
    resource: 'page',
  }
);
</script>

<template>
  <div class="flex flex-col items-center justify-center min-h-screen bg-gray-100 text-center">
    <h1 class="text-6xl font-bold text-red-600 mb-4">Oops!</h1>
    <h3 class="text-2xl text-gray-700 mb-8">
      The {{ resource }} you're looking for is not here.
    </h3>
    <router-link
      :to="{ name: 'medalHome' }"
      class="px-6 py-2 text-lg font-semibold text-white bg-blue-500 rounded hover:bg-blue-600 transition-colors duration-300"
    >
      Go back home page
    </router-link>
  </div>
</template>
