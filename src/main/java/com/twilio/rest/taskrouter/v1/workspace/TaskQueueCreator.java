/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class TaskQueueCreator extends Creator<TaskQueue> {
    private final String pathWorkspaceSid;
    private final String friendlyName;
    private String targetWorkers;
    private Integer maxReservedWorkers;
    private TaskQueue.TaskOrder taskOrder;
    private String reservationActivitySid;
    private String assignmentActivitySid;

    /**
     * Construct a new TaskQueueCreator.
     * 
     * @param pathWorkspaceSid The workspace_sid
     * @param friendlyName Human readable description of this TaskQueue
     */
    public TaskQueueCreator(final String pathWorkspaceSid, 
                            final String friendlyName) {
        this.pathWorkspaceSid = pathWorkspaceSid;
        this.friendlyName = friendlyName;
    }

    /**
     * A string describing the Worker selection criteria for any Tasks that enter
     * this TaskQueue. For example `'"language" == "spanish"'` If no TargetWorkers
     * parameter is provided, Tasks will wait in this TaskQueue until they are
     * either deleted or moved to another TaskQueue. Additional examples on how to
     * describing Worker selection criteria below. Defaults to 1==1..
     * 
     * @param targetWorkers A string describing the Worker selection criteria for
     *                      any Tasks that enter this TaskQueue.
     * @return this
     */
    public TaskQueueCreator setTargetWorkers(final String targetWorkers) {
        this.targetWorkers = targetWorkers;
        return this;
    }

    /**
     * The maximum amount of workers to create reservations for the assignment of a
     * task while in this queue. Defaults to 1, with a Maximum of 50..
     * 
     * @param maxReservedWorkers The maximum amount of workers to create
     *                           reservations for the assignment of a task while in
     *                           this queue.
     * @return this
     */
    public TaskQueueCreator setMaxReservedWorkers(final Integer maxReservedWorkers) {
        this.maxReservedWorkers = maxReservedWorkers;
        return this;
    }

    /**
     * TaskOrder will determine which order the Tasks will be assigned to Workers.
     * Set this parameter to LIFO to assign most recently created Task first or FIFO
     * to assign the oldest Task. Default is FIFO. [Click
     * here](https://www.twilio.com/docs/api/taskrouter/last-first-out-lifo) to
     * learn more..
     * 
     * @param taskOrder TaskOrder will determine which order the Tasks will be
     *                  assigned to Workers.
     * @return this
     */
    public TaskQueueCreator setTaskOrder(final TaskQueue.TaskOrder taskOrder) {
        this.taskOrder = taskOrder;
        return this;
    }

    /**
     * ActivitySID to assign workers once a task is reserved for them.
     * 
     * @param reservationActivitySid ActivitySID to assign workers once a task is
     *                               reserved for them
     * @return this
     */
    public TaskQueueCreator setReservationActivitySid(final String reservationActivitySid) {
        this.reservationActivitySid = reservationActivitySid;
        return this;
    }

    /**
     * ActivitySID to assign workers once a task is assigned for them.
     * 
     * @param assignmentActivitySid ActivitySID to assign workers once a task is
     *                              assigned for them
     * @return this
     */
    public TaskQueueCreator setAssignmentActivitySid(final String assignmentActivitySid) {
        this.assignmentActivitySid = assignmentActivitySid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created TaskQueue
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public TaskQueue create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.pathWorkspaceSid + "/TaskQueues",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("TaskQueue creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return TaskQueue.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (targetWorkers != null) {
            request.addPostParam("TargetWorkers", targetWorkers);
        }

        if (maxReservedWorkers != null) {
            request.addPostParam("MaxReservedWorkers", maxReservedWorkers.toString());
        }

        if (taskOrder != null) {
            request.addPostParam("TaskOrder", taskOrder.toString());
        }

        if (reservationActivitySid != null) {
            request.addPostParam("ReservationActivitySid", reservationActivitySid);
        }

        if (assignmentActivitySid != null) {
            request.addPostParam("AssignmentActivitySid", assignmentActivitySid);
        }
    }
}