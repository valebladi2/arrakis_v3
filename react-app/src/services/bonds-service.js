import http from './axios-common';
export function getAllBondsOfAUser(){
    let bondHolder = "Goldman%20Sachs"
    return http.get(`/getBondsOfUser/${bondHolder}`);
}

export function getRedeemableBonds(){
    let date = "2023-12-20"
    return http.get('/trades/redeemablebonds/2023-09-09');
}