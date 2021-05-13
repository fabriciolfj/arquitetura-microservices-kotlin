package com.github.fabriciolfj.conta.api.exceptions.api

import com.github.fabriciolfj.conta.api.exceptions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import kotlin.streams.toList

@ControllerAdvice
class ApiExceptionHandler : ResponseEntityExceptionHandler() {

    @Autowired
    private lateinit var messageSource : MessageSource

    val MSG = "Validação campos de entrada"

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        return handleValidationInternal(ex, ex.bindingResult, headers, status, request)
    }

    @ExceptionHandler(BancoNotFoundException::class)
    fun handleBancoNotFound(ex: BancoNotFoundException): ResponseEntity<ErrorResponse> {
        var error = ex.message?.let { ErrorResponse(it, HttpStatus.BAD_REQUEST.value()) }
        return ResponseEntity.badRequest().body(error)
    }

    @ExceptionHandler(ContaNotFoundException::class)
    fun handleContaNotFound(ex: ContaNotFoundException): ResponseEntity<ErrorResponse> {
        var error = ex.message?.let { ErrorResponse(it, HttpStatus.BAD_REQUEST.value()) }
        return ResponseEntity.badRequest().body(error)
    }

    @ExceptionHandler(ExtratoNotFoundException::class)
    fun handleExtratoNotFound(ex: ExtratoNotFoundException): ResponseEntity<ErrorResponse> {
        var error = ex.message?.let { ErrorResponse(it, HttpStatus.BAD_REQUEST.value()) }
        return ResponseEntity.badRequest().body(error)
    }

    @ExceptionHandler(LimiteNotFoundException::class)
    fun handleLimiteNotFound(ex: LimiteNotFoundException) : ResponseEntity<ErrorResponse> {
        var error = ex.message?.let { ErrorResponse(ex.message, HttpStatus.BAD_REQUEST.value()) }
        return ResponseEntity.badRequest().body(error)
    }

    @ExceptionHandler(LimiteValorExcedidoException::class)
    fun handleLimiteValorExcedido(ex: LimiteValorExcedidoException) : ResponseEntity<ErrorResponse> {
        var error = ex.message?.let { ErrorResponse(ex.message, HttpStatus.BAD_REQUEST.value()) }
        return ResponseEntity.badRequest().body(error)
    }

    @ExceptionHandler(ValorInvalidoException::class)
    fun handleValorInvalidoException(ex: ValorInvalidoException) : ResponseEntity<ErrorResponse> {
        var error = ex.message?.let { ErrorResponse(ex.message, HttpStatus.BAD_REQUEST.value()) }
        return ResponseEntity.badRequest().body(error)
    }

    @ExceptionHandler(ContaExistsException::class)
    fun handleContaExistsException(ex: ContaExistsException) : ResponseEntity<ErrorResponse> {
        var error = ex.message?.let { ErrorResponse(ex.message, HttpStatus.BAD_REQUEST.value()) }
        return ResponseEntity.badRequest().body(error)
    }

    fun handleValidationInternal(ex: Exception, bindingResult: BindingResult, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        var details = bindingResult.allErrors.stream()
            .map {
                var message = messageSource.getMessage(it, LocaleContextHolder.getLocale())
                var field = it.objectName

                if (it is FieldError) {
                    field = it.field
                }

                DetailsError(message, field)
            }.toList();

        return ResponseEntity.badRequest().body(ErrorResponse(MSG, status.value(), details))
    }
}