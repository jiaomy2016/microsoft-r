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


import io.swagger.client.model.CreateSnapshotRequest;
import io.swagger.client.model.CreateSnapshotResponse;
import io.swagger.client.model.Error;
import io.swagger.client.model.Snapshot;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotAPIsApi {
    private ApiClient apiClient;

    public SnapshotAPIsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SnapshotAPIsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createSnapshot
     * @param id Id of the session. (required)
     * @param createSnapshotRequest Properties of the new snapshot. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createSnapshotCall(String id, CreateSnapshotRequest createSnapshotRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = createSnapshotRequest;
        
        // create path and map variables
        String localVarPath = "/sessions/{id}/snapshot"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
    private com.squareup.okhttp.Call createSnapshotValidateBeforeCall(String id, CreateSnapshotRequest createSnapshotRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling createSnapshot(Async)");
        }
        
        // verify the required parameter 'createSnapshotRequest' is set
        if (createSnapshotRequest == null) {
            throw new ApiException("Missing the required parameter 'createSnapshotRequest' when calling createSnapshot(Async)");
        }
        
        
        com.squareup.okhttp.Call call = createSnapshotCall(id, createSnapshotRequest, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create Snapshot
     * Create a snapshot from session by saving the workspace and all files in the working directory into zip file, the return value will be the created snapshot Id.
     * @param id Id of the session. (required)
     * @param createSnapshotRequest Properties of the new snapshot. (required)
     * @return CreateSnapshotResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CreateSnapshotResponse createSnapshot(String id, CreateSnapshotRequest createSnapshotRequest) throws ApiException {
        ApiResponse<CreateSnapshotResponse> resp = createSnapshotWithHttpInfo(id, createSnapshotRequest);
        return resp.getData();
    }

    /**
     * Create Snapshot
     * Create a snapshot from session by saving the workspace and all files in the working directory into zip file, the return value will be the created snapshot Id.
     * @param id Id of the session. (required)
     * @param createSnapshotRequest Properties of the new snapshot. (required)
     * @return ApiResponse&lt;CreateSnapshotResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CreateSnapshotResponse> createSnapshotWithHttpInfo(String id, CreateSnapshotRequest createSnapshotRequest) throws ApiException {
        com.squareup.okhttp.Call call = createSnapshotValidateBeforeCall(id, createSnapshotRequest, null, null);
        Type localVarReturnType = new TypeToken<CreateSnapshotResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create Snapshot (asynchronously)
     * Create a snapshot from session by saving the workspace and all files in the working directory into zip file, the return value will be the created snapshot Id.
     * @param id Id of the session. (required)
     * @param createSnapshotRequest Properties of the new snapshot. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createSnapshotAsync(String id, CreateSnapshotRequest createSnapshotRequest, final ApiCallback<CreateSnapshotResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createSnapshotValidateBeforeCall(id, createSnapshotRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CreateSnapshotResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for listSnapshots
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call listSnapshotsCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/snapshots";

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call listSnapshotsValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = listSnapshotsCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get Snapshots
     * List all the snapshots for the current user and display some info such as Id, display name, creation time, zip file size and owner for this snapshot.
     * @return List&lt;Snapshot&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Snapshot> listSnapshots() throws ApiException {
        ApiResponse<List<Snapshot>> resp = listSnapshotsWithHttpInfo();
        return resp.getData();
    }

    /**
     * Get Snapshots
     * List all the snapshots for the current user and display some info such as Id, display name, creation time, zip file size and owner for this snapshot.
     * @return ApiResponse&lt;List&lt;Snapshot&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Snapshot>> listSnapshotsWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = listSnapshotsValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<List<Snapshot>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get Snapshots (asynchronously)
     * List all the snapshots for the current user and display some info such as Id, display name, creation time, zip file size and owner for this snapshot.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call listSnapshotsAsync(final ApiCallback<List<Snapshot>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = listSnapshotsValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Snapshot>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for loadSnapshot
     * @param id Id of the session. (required)
     * @param snapshotId Id of the saved snapshot. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call loadSnapshotCall(String id, String snapshotId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/sessions/{id}/loadsnapshot/{snapshotId}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
            .replaceAll("\\{" + "snapshotId" + "\\}", apiClient.escapeString(snapshotId.toString()));

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
    private com.squareup.okhttp.Call loadSnapshotValidateBeforeCall(String id, String snapshotId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling loadSnapshot(Async)");
        }
        
        // verify the required parameter 'snapshotId' is set
        if (snapshotId == null) {
            throw new ApiException("Missing the required parameter 'snapshotId' when calling loadSnapshot(Async)");
        }
        
        
        com.squareup.okhttp.Call call = loadSnapshotCall(id, snapshotId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Load Snapshot
     * Loads a snapshot into session by merging the workspace of the saved snapshot and target session. It will override the files in the working directory as well.   **Note - ** You can only load R snapshots to R session and Python snapshots to a Python session.
     * @param id Id of the session. (required)
     * @param snapshotId Id of the saved snapshot. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void loadSnapshot(String id, String snapshotId) throws ApiException {
        loadSnapshotWithHttpInfo(id, snapshotId);
    }

    /**
     * Load Snapshot
     * Loads a snapshot into session by merging the workspace of the saved snapshot and target session. It will override the files in the working directory as well.   **Note - ** You can only load R snapshots to R session and Python snapshots to a Python session.
     * @param id Id of the session. (required)
     * @param snapshotId Id of the saved snapshot. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> loadSnapshotWithHttpInfo(String id, String snapshotId) throws ApiException {
        com.squareup.okhttp.Call call = loadSnapshotValidateBeforeCall(id, snapshotId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Load Snapshot (asynchronously)
     * Loads a snapshot into session by merging the workspace of the saved snapshot and target session. It will override the files in the working directory as well.   **Note - ** You can only load R snapshots to R session and Python snapshots to a Python session.
     * @param id Id of the session. (required)
     * @param snapshotId Id of the saved snapshot. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call loadSnapshotAsync(String id, String snapshotId, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = loadSnapshotValidateBeforeCall(id, snapshotId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
