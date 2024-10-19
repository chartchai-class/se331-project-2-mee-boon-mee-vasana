<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import EventService from '@/services/EventService';
import { type Country } from '@/types';

const route = useRoute();
const countryId = route.params.id as string;
const country = ref<Country | null>(null);
const isLoading = ref(true);

onMounted(() => {
  EventService.getCountry(Number(countryId))
    .then((response) => {
      country.value = response.data;
      isLoading.value = false;
    })
    .catch(error => {
      console.error("Error fetching country details:", error);
      isLoading.value = false;
    });
});
</script>

<template>
  <div v-if="isLoading" class="flex items-center justify-center min-h-screen">
    <p class="text-lg text-gray-600">Loading country details...</p>
  </div>

  <div v-else-if="country" class="country-detail-page max-w-4xl mx-auto px-4 py-8">
    <div class="bg-gradient-to-r from-blue-600 to-indigo-700 text-white p-8 rounded-xl shadow-2xl mb-8">
      <h1 class="text-4xl md:text-5xl font-bold mb-2">{{ country.name }}</h1>
      <p class="text-xl opacity-80">{{ country.nocCode }}</p>
    </div>

    <div class="flex flex-col md:flex-row gap-8">
      <img 
        :src="country.flagUrl" 
        :alt="`${country.name} Flag`" 
        class="w-full md:w-1/3 h-auto rounded-lg shadow-lg border-4 border-white"
      />
      <div class="flex-1 bg-white p-6 rounded-lg shadow-lg">
        <h2 class="text-2xl font-semibold text-gray-800 mb-4">Country Details</h2>
        <p class="text-gray-600 mb-4">
          <span class="font-semibold text-gray-800">Name:</span> {{ country.name }}
        </p>
        <p class="text-gray-600 mb-4">
          <span class="font-semibold text-gray-800">Code:</span> {{ country.nocCode }}
        </p>
        <p class="text-gray-600">
          <span class="font-semibold text-gray-800">Description:</span> {{ country.description }}
        </p>
      </div>
    </div>
  </div>

  <div v-else class="flex items-center justify-center min-h-screen">
    <p class="text-lg text-gray-600">Country details not found.</p>
  </div>
</template>
