import http from './axios-common';
export function getAllBondsOfAUser(){
    let bondHolder = "Goldman%20Sachs"
    return http.get(`/getBondsOfUser/${bondHolder}`);
}