package com.example.wongnaiassignmentapplication.api

sealed class APIResponseType()

class ApiSuccess: APIResponseType()
class ApiError: APIResponseType()
class HttpError: APIResponseType()