<script setup lang="ts">
import { onMounted, watchEffect } from 'vue';
import { useCountryStore } from '@/stores/countryStore';
import { useRoute } from 'vue-router';

const countryStore = useCountryStore();
const route = useRoute();

// Sync the store with the route on mount and whenever the route changes
onMounted(() => {
  countryStore.syncWithRoute();
});

watchEffect(() => {
  countryStore.syncWithRoute();
});
</script>

<template>
  <div class="max-w-7xl mx-auto p-5">
    <div class="mb-4">
      <label for="countries-per-page" class="block text-sm font-medium text-gray-700">
        Number of countries per page (1-15):
      </label>
      <input
        id="countries-per-page"
        type="number"
        class="mt-1 block w-20 p-2 border border-gray-300 rounded-md"
        :value="countryStore.countriesPerPage"
        @input="(e) => countryStore.updateCountriesPerPage(parseInt((e.target as HTMLInputElement)?.value))"
        min="1"
        max="15"
      />
    </div>

    <div class="bg-white shadow-md rounded-lg overflow-hidden">
      <div class="overflow-x-auto">
        <table class="w-full table-auto">
          <thead>
            <tr class="bg-gradient-to-r from-blue-500 to-blue-600 text-white">
              <th class="py-3 px-2 sm:px-4 font-semibold text-xs sm:text-sm uppercase text-left">Rank</th>
              <th class="py-3 px-2 sm:px-4 font-semibold text-xs sm:text-sm uppercase text-left">Country</th>
              <th class="py-3 px-2 sm:px-4 font-semibold text-xs sm:text-sm uppercase text-center">🥇 Gold</th>
              <th class="py-3 px-2 sm:px-4 font-semibold text-xs sm:text-sm uppercase text-center">🥈 Silver</th>
              <th class="py-3 px-2 sm:px-4 font-semibold text-xs sm:text-sm uppercase text-center">🥉 Bronze</th>
              <th class="py-3 px-2 sm:px-4 font-semibold text-xs sm:text-sm uppercase text-center">Total</th>
              <th class="py-3 px-2 sm:px-4 font-semibold text-xs sm:text-sm uppercase text-center">Details</th>
            </tr>
          </thead>
          <tbody>
            <template v-for="(country, index) in countryStore.paginatedCountries" :key="country.id">
              <tr class="border-b border-gray-200 hover:bg-gray-50 transition duration-150">
                <td class="py-2 sm:py-3 px-2 sm:px-4 text-gray-800 text-xs sm:text-sm">
                  {{ (countryStore.currentPage - 1) * countryStore.countriesPerPage + index + 1 }}
                </td>
                <td class="py-2 sm:py-3 px-2 sm:px-4">
                  <div class="flex items-center">
                    <img
                      :src="country.flagUrl"
                      alt="Flag"
                      class="w-4 h-4 sm:w-6 sm:h-6 rounded-full mr-2 sm:mr-3 border border-gray-300"
                    />
                    <span class="font-medium text-gray-700 text-xs sm:text-sm">{{ country.name }}</span>
                  </div>
                </td>
                <td class="py-2 sm:py-3 px-2 sm:px-4 text-center font-semibold text-xs sm:text-sm text-yellow-500">
                  {{ country.gold }}
                </td>
                <td class="py-2 sm:py-3 px-2 sm:px-4 text-center font-semibold text-xs sm:text-sm text-gray-500">
                  {{ country.silver }}
                </td>
                <td class="py-2 sm:py-3 px-2 sm:px-4 text-center font-semibold text-xs sm:text-sm text-amber-600">
                  {{ country.bronze }}
                </td>
                <td class="py-2 sm:py-3 px-2 sm:px-4 text-center font-bold text-xs sm:text-sm text-blue-600">
                  {{ country.total }}
                </td>
                <td class="py-2 sm:py-3 px-2 sm:px-4 text-center">
                  <RouterLink
                    :to="{ name: 'detail-view', params: { id: country.id } }"
                    class="inline-block py-1 sm:py-2 px-2 sm:px-4 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-400 focus:ring-opacity-75 transition duration-300 ease-in-out transform hover:-translate-y-1 hover:scale-105 text-xs sm:text-sm"
                  >
                    View more details
                  </RouterLink>
                </td>
              </tr>
            </template>
          </tbody>
        </table>
      </div>
    </div>

    <!-- Pagination Controls -->
    <div class="mt-4 flex justify-between">
      <div>
        <template v-if="countryStore.currentPage > 1">
          <RouterLink
            :to="{ query: { page: String(countryStore.currentPage - 1), pageSize: String(countryStore.countriesPerPage) } }"
            class="px-2 sm:px-3 py-1 sm:py-2 bg-gray-300 rounded cursor-pointer text-xs sm:text-sm"
          >
            Previous
          </RouterLink>
        </template>
        <span
          v-else
          class="px-2 sm:px-3 py-1 sm:py-2 bg-gray-300 rounded cursor-not-allowed opacity-50 text-xs sm:text-sm"
        >
          Previous
        </span>
      </div>

      <span class="text-gray-700 text-xs sm:text-sm">
        Page {{ countryStore.currentPage }} of {{ countryStore.totalPages }}
      </span>

      <div>
        <template v-if="countryStore.currentPage < countryStore.totalPages">
          <RouterLink
            :to="{ query: { page: String(countryStore.currentPage + 1), pageSize: String(countryStore.countriesPerPage) } }"
            class="px-2 sm:px-3 py-1 sm:py-2 bg-gray-300 rounded cursor-pointer text-xs sm:text-sm"
          >
            Next
          </RouterLink>
        </template>
        <span
          v-else
          class="px-2 sm:px-3 py-1 sm:py-2 bg-gray-300 rounded cursor-not-allowed opacity-50 text-xs sm:text-sm"
        >
          Next
        </span>
      </div>
    </div>
  </div>
</template>
