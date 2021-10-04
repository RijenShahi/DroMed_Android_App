package com.rijen.dromedapp.repository

import com.rijen.dromedapp.api.ApiRequest
import com.rijen.dromedapp.api.ProductApi
import com.rijen.dromedapp.api.ServiceBuilder
import com.rijen.dromedapp.response.AddProductResponse
import com.rijen.dromedapp.response.CartResponse
import com.rijen.dromedapp.response.GlobalResponse
import com.rijen.dromedapp.response.ProductResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody

class ProductRepository : ApiRequest() {
    val egApi = ServiceBuilder.buildService(ProductApi::class.java)

    suspend fun addProduct(name: RequestBody, desc: RequestBody, price: RequestBody, rating: RequestBody, image: MultipartBody.Part): AddProductResponse {
        return apiRequest {
            egApi.addProduct(ServiceBuilder.token!!,name, desc, price, rating, image)
        }
    }

    suspend fun getProducts(): ProductResponse {
        return apiRequest {
            egApi.getProduct()
        }
    }

    suspend fun addToCart(productID: String): GlobalResponse {
        return apiRequest {
            egApi.addToCart(ServiceBuilder.token!!, productID)
        }
    }
    suspend fun deleteFromCart(productID: String): GlobalResponse {
        return apiRequest {
            egApi.deleteFromCart(ServiceBuilder.token!!, productID)
        }
    }

    suspend fun getCart(): CartResponse {
        return apiRequest {
            egApi.getCart(ServiceBuilder.token!!)
        }
    }

    suspend fun updateFromCart(productID: String, quantity: Int): GlobalResponse {
        return apiRequest {
            egApi.updateFromCart(ServiceBuilder.token!!, productID, quantity)
        }
    }


}
