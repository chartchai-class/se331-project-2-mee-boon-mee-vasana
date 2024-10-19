<script setup lang="ts">
import { RouterLink, useRoute } from 'vue-router'

const route = useRoute()

const links = [
  { to: '/', label: 'Medal Table' },
  { to: '/CheerUp', label: 'Cheer up!' }
]
</script>

<template>
  <div class="min-h-screen flex flex-col bg-gradient-to-br from-blue-50 to-indigo-100">
    <header class="bg-white shadow-sm p-6">
      <h1 class="text-2xl md:text-3xl font-bold text-center text-indigo-800">Mee Boon Olympic</h1>
    </header>
    <div class="flex-grow flex flex-col md:flex-row p-6">
      <!-- Navigation -->
      <nav class="md:w-64 bg-white rounded-lg shadow-md p-6 mb-6 md:mb-0 md:mr-6">
        <div class="space-y-4">
          <RouterLink
            v-for="link in links"
            :key="link.to"
            :to="link.to"
            class="block py-2 px-4 rounded-md transition-colors duration-200"
            :class="route.path === link.to ? 'bg-indigo-600 text-white font-medium' : 'text-gray-700 hover:bg-indigo-100'"
          >
            {{ link.label }}
          </RouterLink>
        </div>
      </nav>

      <!-- Main Content -->
      <main class="flex-grow bg-white rounded-lg shadow-md p-6">
        <RouterView />
      </main>
    </div>
    
    <!-- Footer -->
    <footer class="bg-white shadow-sm p-4">
      <p class="text-center text-sm text-gray-600">&copy; 2024 Mee Boon Olympic. All rights reserved.</p>
    </footer>
  </div>
</template>
