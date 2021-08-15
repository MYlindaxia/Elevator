import axios from "axios";


axios.defaults.baseURL = "http://127.0.0.1:8083";
axios.interceptors.request.use((config) => {
  let token  = window.sessionStorage.getItem("token");

  if(token) {
    config.headers["token"] = token;
  }
  return config;
},function(error) {
  return Promise.reject(error);
})