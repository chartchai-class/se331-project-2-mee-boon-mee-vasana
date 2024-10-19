<script setup lang="ts">
import { ref, onMounted, defineProps } from 'vue';
import { type Country } from '@/types';
import EventService from '@/services/EventService';
// import nProgress from 'nprogress';

const event = ref<Country | null>(null);
const props = defineProps({
  id: {
    type: String,
    required: true,
  },
});

onMounted(() => {
  EventService.getCountry(parseInt(props.id))
    .then((response) => {
      event.value = response.data;
      // nProgress.start();
    })
    .catch((error) => {
      console.log('There was an error!', error);
    });
  // .finally(() => {
  //   nProgress.done();
  // });
});
</script>

<template>
  <div v-if="event" class="container mx-auto py-8 px-4">
    <!-- Main Section -->
    <div class="bg-blue-50 p-8 rounded-xl shadow-2xl">
      <div class="flex flex-col lg:flex-row items-center justify-between gap-8">
        <!-- Event Details -->
        <div class="text-center lg:text-left lg:w-1/2">
          <h1 class="text-5xl font-extrabold text-blue-700 mb-4">{{ event.name }}</h1>
          <p class="text-blue-800 text-lg">
            Welcome to the {{ event.name }} detail page. Explore the details and sports involved in this grand event.
          </p>
        </div>

        <!-- Navigation Links -->
        <nav class="flex flex-col sm:flex-row gap-4 lg:w-1/2">
          <router-link
            :to="{ name: 'country-detail-view' }"
            class="text-lg font-bold py-3 px-6 rounded-lg transition duration-300 ease-in-out transform hover:scale-105 text-center"
            :class="[$route.name === 'country-detail-view' 
              ? 'bg-blue-700 text-white' 
              : 'bg-white text-blue-600 border-2 border-blue-600 hover:bg-blue-100']"
          >
            {{ event.name }} Details
          </router-link>

          <router-link
            :to="{ name: 'sport-list-view' }"
            class="text-lg font-bold py-3 px-6 rounded-lg transition duration-300 ease-in-out transform hover:scale-105 text-center"
            :class="[$route.name === 'sport-list-view' 
              ? 'bg-blue-700 text-white' 
              : 'bg-white text-blue-600 border-2 border-blue-600 hover:bg-blue-100']"
          >
            Sport List
          </router-link>
        </nav>
      </div>
    </div>

    <!-- Router View Section -->
    <div class="mt-12">
      <RouterView :event="event" />
    </div>
  </div>
</template>
