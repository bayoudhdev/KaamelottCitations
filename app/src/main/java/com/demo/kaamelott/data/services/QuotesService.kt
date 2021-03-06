package com.demo.kaamelott.data.services

import com.demo.kaamelott.data.entities.QuoteEntity
import com.demo.kaamelott.data.entities.QuotesEntity
import com.demo.kaamelott.data.entities.RandomQuoteEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface QuotesService {
    /**
     * Get a random quote
     *
     * Responses:
     *  - 200: Request is successful, response contains the random quote
     *  - 404: Unrecoverable error from the service
     *
     * @return [QuoteEntity]
     */
    @GET("/api/random")
    suspend fun getRandomQuote(): Response<RandomQuoteEntity>

    /**
     * Get all quotes by book
     *
     * Responses:
     *  - 200: Request is successful, response contains the all quotes
     *  - 404: Unrecoverable error from the service
     *
     * @param book a book number
     * @return [QuotesEntity]
     */
    @GET("/api/all/livre/{book}")
    suspend fun getAllQuotesByBook(
        @Path("book") book: String
    ): Response<QuotesEntity>

    /**
     * Get all quotes by book and personage
     *
     * Responses:
     *  - 200: Request is successful, response contains the all quotes
     *  - 404: Unrecoverable error from the service
     *
     * @param book a book number
     * @param personage name of the personage in the book
     * @return [QuotesEntity]
     */
    @GET("/api/all/livre/{book}/personnage/{personage}")
    suspend fun getQuotesByBookAndPersonage(
        @Path("book") book: String,
        @Path("personage") personage: String
    ): Response<QuotesEntity>

    /**
     * Get all quotes by personage
     *
     * Responses:
     *  - 200: Request is successful, response contains the all quotes
     *  - 404: Unrecoverable error from the service
     *
     * @param personage name of the personage in the book
     * @return [QuotesEntity]
     */
    @GET("/api/all/personnage/{personage}")
    suspend fun getQuotesByPersonage(
        @Path("personage") personage: String
    ): Response<QuotesEntity>
}
