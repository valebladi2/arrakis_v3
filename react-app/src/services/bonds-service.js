import http from './axios-common';
export function getAllBondsOfAUser(bondHolder){
    return http.get(`/getBondsOfUser/${encodeURIComponent(bondHolder)}`);
}

export function getAllBonds(){
    return http.get(`/getAllBooks`);
}

export function getBondsForPlusMinus5Days(bondDate){
    return http.get(`/getBondsPlusMinus5Days/${encodeURIComponent(bondDate)}`);
}