import axios from 'axios'

const apiClient = axios.create({
  baseURL: 'https://my-json-server.typicode.com/SammyEiei/mee-boon-server',
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  }
})

export default {
  getEvent() {
    return apiClient.get('/countries');
  },
  getCountry(id: number) {
    return apiClient.get(`/countries/${id}`);
  },
  getCountries(perPage: number, page: number) {
    return apiClient.get(`/countries?_limit=${perPage}&_page=${page}`);
  }
}

