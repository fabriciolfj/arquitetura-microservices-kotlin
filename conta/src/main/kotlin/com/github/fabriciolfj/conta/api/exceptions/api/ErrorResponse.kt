package com.github.fabriciolfj.conta.api.exceptions.api

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorResponse(var message: String, var status: Int, var erros: List<DetailsError>?) {

    constructor(message: String, status: Int) : this(message, status, null)
}