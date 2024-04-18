/**
 * Add scenario
 */
INSERT INTO dbs.scenario (name, notifications_to_delete, notifications_to_create)
VALUES ('Scenario.AAA6.ClaimIssue.Response.Await',
        '{"Notice.AAA6.ClaimIssue.ClaimFee.Required", "Notice.AAA6.ClaimIssue.HWF.Requested", "Notice.AAA6.ClaimIssue.HWF.InvalidRef", "Notice.AAA6.ClaimIssue.HWF.InfoRequired", "Notice.AAA6.ClaimIssue.HWF.Updated", "Notice.AAA6.ClaimIssue.HWF.PartRemission", "Notice.AAA6.ClaimIssue.HWF.Rejected", "Notice.AAA6.ClaimIssue.HWF.PhonePayment", "Notice.AAA6.ClaimIssue.HWF.FullRemission"}',
        '{"Notice.AAA6.ClaimIssue.Response.Await":["respondent1ResponseDeadlineEn", "respondent1ResponseDeadlineCy", "respondent1PartyName"]}');

/**
 * Add notification template
 */
INSERT INTO dbs.dashboard_notifications_templates (template_name, title_En, title_Cy, description_En, description_Cy
                                                  ,notification_role)
VALUES ('Notice.AAA6.ClaimIssue.Response.Await', 'Wait for defendant to respond', 'Wait for defendant to respond',
        '<p class="govuk-body">${respondent1PartyName} has until ${respondent1ResponseDeadlineEn} to respond. They can request an extra 28 days if they need it.</p>',
        '<p class="govuk-body">${respondent1PartyName} has until ${respondent1ResponseDeadlineCy} to respond. They can request an extra 28 days if they need it.</p>',
        'CLAIMANT');

/**
 * Add task list items
 */
INSERT INTO dbs.task_item_template (task_name_en, category_en, task_name_cy, category_cy, template_name,
                                    scenario_name, task_status_sequence, role, task_order)
values ('<a href={VIEW_CLAIM_URL} rel="noopener noreferrer" class="govuk-link">View the claim</a>', 'The claim','<a href={VIEW_CLAIM_URL}>View the claim</a>',
        'The claim', 'Claim.View', 'Scenario.AAA6.ClaimIssue.Response.Await', '{3, 3}', 'CLAIMANT', 1),
       ('<a href={VIEW_INFO_ABOUT_CLAIMANT} rel="noopener noreferrer" class="govuk-link">View information about the claimant</a>', 'The claim','<a href={VIEW_INFO_ABOUT_CLAIMANT}>View information about the claimant</a>',
        'The claim', 'Claim.Claimant.Info', 'Scenario.AAA6.ClaimIssue.Response.Await', '{3, 3}', 'CLAIMANT', 2),
       ('<a href={VIEW_INFO_ABOUT_DEFENDANT} rel="noopener noreferrer" class="govuk-link">View information about the defendant</a>', 'The response','<a href={VIEW_INFO_ABOUT_DEFENDANT}>View information about the defendant</a>',
        'The response', 'Response.Defendant.Info', 'Scenario.AAA6.ClaimIssue.Response.Await', '{3, 3}', 'CLAIMANT', 4),
       ('<a href={VIEW_ORDERS_AND_NOTICES} rel="noopener noreferrer" class="govuk-link">View orders and notices</a>', 'Orders and notices from the court' ,'<a href={VIEW_ORDERS_AND_NOTICES}>View orders and notices</a>',
        'Orders and notices from the court', 'Order.View', 'Scenario.AAA6.ClaimIssue.Response.Await', '{3, 3}', 'CLAIMANT', 13);