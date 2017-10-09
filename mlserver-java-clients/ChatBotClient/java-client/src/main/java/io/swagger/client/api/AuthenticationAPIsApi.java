/*
 * MLServer
 * Integration technology for deploying R and Python analytics inside web, desktop, mobile, and dashboard applications as well as backend systems. Turn your R or Python scripts into analytics web services, so code can be easily executed by applications running on a secure server.  The core APIs can be grouped into several categories, including: [Authentication](#authentication-apis), [Web Services](#services-management-apis), [Sessions](#session-apis), [Snapshots](#snapshot-apis), [Status](#status-apis), and [Centralized Configuration](#centralized-configuration-apis). 
 *
 * OpenAPI spec version: 9.2.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.AccessTokenResponse;
import io.swagger.client.model.Error;
import io.swagger.client.model.LoginRequest;
import io.swagger.client.model.RenewTokenRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthenticationAPIsApi {
    private ApiClient apiClient;

    public AuthenticationAPIsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AuthenticationAPIsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for login
     * @param loginRequest Login properties for athentication. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call loginCall(LoginRequest loginRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = loginRequest;
        
        // create path and map variables
        String localVarPath = "/login";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call loginValidateBeforeCall(LoginRequest loginRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'loginRequest' is set
        if (loginRequest == null) {
            throw new ApiException("Missing the required parameter 'loginRequest' when calling login(Async)");
        }
        
        
        com.squareup.okhttp.Call call = loginCall(loginRequest, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Login User
     * Logs the user in.
     * @param loginRequest Login properties for athentication. (required)
     * @return AccessTokenResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AccessTokenResponse login(LoginRequest loginRequest) throws ApiException {
        ApiResponse<AccessTokenResponse> resp = loginWithHttpInfo(loginRequest);
        return resp.getData();
    }

    /**
     * Login User
     * Logs the user in.
     * @param loginRequest Login properties for athentication. (required)
     * @return ApiResponse&lt;AccessTokenResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AccessTokenResponse> loginWithHttpInfo(LoginRequest loginRequest) throws ApiException {
        com.squareup.okhttp.Call call = loginValidateBeforeCall(loginRequest, null, null);
        Type localVarReturnType = new TypeToken<AccessTokenResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Login User (asynchronously)
     * Logs the user in.
     * @param loginRequest Login properties for athentication. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call loginAsync(LoginRequest loginRequest, final ApiCallback<AccessTokenResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = loginValidateBeforeCall(loginRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AccessTokenResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for renewToken
     * @param renewTokenRequest Renew access token properties for athentication. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call renewTokenCall(RenewTokenRequest renewTokenRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = renewTokenRequest;
        
        // create path and map variables
        String localVarPath = "/login/refreshToken";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call renewTokenValidateBeforeCall(RenewTokenRequest renewTokenRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'renewTokenRequest' is set
        if (renewTokenRequest == null) {
            throw new ApiException("Missing the required parameter 'renewTokenRequest' when calling renewToken(Async)");
        }
        
        
        com.squareup.okhttp.Call call = renewTokenCall(renewTokenRequest, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Refresh User Access Token
     * The user renews access token and refresh token.
     * @param renewTokenRequest Renew access token properties for athentication. (required)
     * @return AccessTokenResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AccessTokenResponse renewToken(RenewTokenRequest renewTokenRequest) throws ApiException {
        ApiResponse<AccessTokenResponse> resp = renewTokenWithHttpInfo(renewTokenRequest);
        return resp.getData();
    }

    /**
     * Refresh User Access Token
     * The user renews access token and refresh token.
     * @param renewTokenRequest Renew access token properties for athentication. (required)
     * @return ApiResponse&lt;AccessTokenResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AccessTokenResponse> renewTokenWithHttpInfo(RenewTokenRequest renewTokenRequest) throws ApiException {
        com.squareup.okhttp.Call call = renewTokenValidateBeforeCall(renewTokenRequest, null, null);
        Type localVarReturnType = new TypeToken<AccessTokenResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Refresh User Access Token (asynchronously)
     * The user renews access token and refresh token.
     * @param renewTokenRequest Renew access token properties for athentication. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call renewTokenAsync(RenewTokenRequest renewTokenRequest, final ApiCallback<AccessTokenResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = renewTokenValidateBeforeCall(renewTokenRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AccessTokenResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for revokeRefreshToken
     * @param refreshToken The refresh token to be revoked. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call revokeRefreshTokenCall(String refreshToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/login/refreshToken";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (refreshToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "refreshToken", refreshToken));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call revokeRefreshTokenValidateBeforeCall(String refreshToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'refreshToken' is set
        if (refreshToken == null) {
            throw new ApiException("Missing the required parameter 'refreshToken' when calling revokeRefreshToken(Async)");
        }
        
        
        com.squareup.okhttp.Call call = revokeRefreshTokenCall(refreshToken, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete User Access Token
     * The user revokes a refresh token.
     * @param refreshToken The refresh token to be revoked. (required)
     * @return AccessTokenResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AccessTokenResponse revokeRefreshToken(String refreshToken) throws ApiException {
        ApiResponse<AccessTokenResponse> resp = revokeRefreshTokenWithHttpInfo(refreshToken);
        return resp.getData();
    }

    /**
     * Delete User Access Token
     * The user revokes a refresh token.
     * @param refreshToken The refresh token to be revoked. (required)
     * @return ApiResponse&lt;AccessTokenResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AccessTokenResponse> revokeRefreshTokenWithHttpInfo(String refreshToken) throws ApiException {
        com.squareup.okhttp.Call call = revokeRefreshTokenValidateBeforeCall(refreshToken, null, null);
        Type localVarReturnType = new TypeToken<AccessTokenResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete User Access Token (asynchronously)
     * The user revokes a refresh token.
     * @param refreshToken The refresh token to be revoked. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call revokeRefreshTokenAsync(String refreshToken, final ApiCallback<AccessTokenResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = revokeRefreshTokenValidateBeforeCall(refreshToken, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AccessTokenResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
