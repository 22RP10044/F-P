<form action="MissionApprovalServlet" method="post">
    <div class="form-group">
        <label for="order-id">Order_ID</label>
        <input type="text" class="form-control" id="order-id" name="order_id" required>
    </div>
    <div class="form-group">
        <label for="approved-by">Approved_By</label>
        <input type="text" class="form-control" id="approved-by" name="approved_by" required>
    </div>
    <div class="form-group">
        <label for="approval-status">Approval_Status</label>
        <textarea class="form-control" id="approval-status" name="approval_status" rows="4" required></textarea>
    </div>
    <div class="form-group">
        <label for="approval-date">Approval_Date</label>
        <input type="date" class="form-control" id="approval-date" name="approval_date" required>
    </div>
    <div class="form-group">
        <label for="comments">Comments</label>
        <input type="text" class="form-control" id="comments" name="comments" required>
    </div>
    <div class="form-group">
        <input type="submit" class="btn btn-primary" value="Submit">
    </div>
</form>
