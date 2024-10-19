import { defineStore } from 'pinia';
import { ref } from 'vue';

export const CommentStore = defineStore('commentStore', () => {
  const comments = ref<{ [key: string]: { comments: string[], flagUrl: string } }>({});

  const addComment = (country: string, comment: string, flagUrl: string) => {
    if (!comments.value[country]) {
      comments.value[country] = {
        comments: [],
        flagUrl: flagUrl
      };
    }
    comments.value[country].comments.push(comment);
  };

  return { comments, addComment };
});
