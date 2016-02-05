package com.twilio.sdk.readers.taskrouter.v1.workspace;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.converters.MarshalConverter;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.readers.Reader;
import com.twilio.sdk.resources.Page;
import com.twilio.sdk.resources.ResourceSet;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.taskrouter.v1.workspace.Event;
import org.joda.time.DateTime;

public class EventReader extends Reader<Event> {
    private final String workspaceSid;
    private DateTime endDate;
    private String eventType;
    private Integer minutes;
    private String reservationSid;
    private DateTime startDate;
    private String taskQueueSid;
    private String taskSid;
    private String workerSid;
    private String workflowSid;

    /**
     * Construct a new EventReader
     * 
     * @param workspaceSid The workspace_sid
     */
    public EventReader(final String workspaceSid) {
        this.workspaceSid = workspaceSid;
    }

    /**
     * The end_date
     * 
     * @param endDate The end_date
     * @return this
     */
    public EventReader byEndDate(final DateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The event_type
     * 
     * @param eventType The event_type
     * @return this
     */
    public EventReader byEventType(final String eventType) {
        this.eventType = eventType;
        return this;
    }

    /**
     * The minutes
     * 
     * @param minutes The minutes
     * @return this
     */
    public EventReader byMinutes(final Integer minutes) {
        this.minutes = minutes;
        return this;
    }

    /**
     * The reservation_sid
     * 
     * @param reservationSid The reservation_sid
     * @return this
     */
    public EventReader byReservationSid(final String reservationSid) {
        this.reservationSid = reservationSid;
        return this;
    }

    /**
     * The start_date
     * 
     * @param startDate The start_date
     * @return this
     */
    public EventReader byStartDate(final DateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The task_queue_sid
     * 
     * @param taskQueueSid The task_queue_sid
     * @return this
     */
    public EventReader byTaskQueueSid(final String taskQueueSid) {
        this.taskQueueSid = taskQueueSid;
        return this;
    }

    /**
     * The task_sid
     * 
     * @param taskSid The task_sid
     * @return this
     */
    public EventReader byTaskSid(final String taskSid) {
        this.taskSid = taskSid;
        return this;
    }

    /**
     * The worker_sid
     * 
     * @param workerSid The worker_sid
     * @return this
     */
    public EventReader byWorkerSid(final String workerSid) {
        this.workerSid = workerSid;
        return this;
    }

    /**
     * The workflow_sid
     * 
     * @param workflowSid The workflow_sid
     * @return this
     */
    public EventReader byWorkflowSid(final String workflowSid) {
        this.workflowSid = workflowSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Event ResourceSet
     */
    @Override
    public ResourceSet<Event> execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            TwilioRestClient.Domains.TASKROUTER,
            "/v1/Workspaces/" + this.workspaceSid + "/Events",
            client.getAccountSid()
        );
        
        addQueryParams(request);
        
        Page<Event> page = pageForRequest(client, request);
        
        return new ResourceSet<>(this, client, page);
    }

    /**
     * Retrieve the next page from the Twilio API
     * 
     * @param nextPageUri URI from which to retrieve the next page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Event> nextPage(final String nextPageUri, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            nextPageUri,
            client.getAccountSid()
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Event Resources for a given request
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    protected Page<Event> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Event read failed: Unable to connect to server");
        } else if (response.getStatusCode() != TwilioRestClient.HTTP_STATUS_CODE_OK) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null)
                throw new ApiException("Server Error, no content");
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        Page<Event> result = new Page<>();
        result.deserialize("events", response.getContent(), Event.class, client.getObjectMapper());
        
        return result;
    }

    /**
     * Add the requested query string arguments to the Request
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toString());
        }
        
        if (eventType != null) {
            request.addQueryParam("EventType", eventType);
        }
        
        if (minutes != null) {
            request.addQueryParam("Minutes", minutes.toString());
        }
        
        if (reservationSid != null) {
            request.addQueryParam("ReservationSid", reservationSid);
        }
        
        if (startDate != null) {
            request.addQueryParam("StartDate", startDate.toString());
        }
        
        if (taskQueueSid != null) {
            request.addQueryParam("TaskQueueSid", taskQueueSid);
        }
        
        if (taskSid != null) {
            request.addQueryParam("TaskSid", taskSid);
        }
        
        if (workerSid != null) {
            request.addQueryParam("WorkerSid", workerSid);
        }
        
        if (workflowSid != null) {
            request.addQueryParam("WorkflowSid", workflowSid);
        }
        
        request.addQueryParam("PageSize", Integer.toString(getPageSize()));
    }
}