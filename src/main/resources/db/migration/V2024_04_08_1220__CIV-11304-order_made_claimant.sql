/**
 * Add scenario
 */
INSERT INTO dbs.scenario (name, notifications_to_delete, notifications_to_create)
VALUES ('Scenario.AAA6.CP.OrderMade.Claimant', '{}', '{"Notice.AAA6.CP.OrderMade.Claimant" : ["orderDocument"]}');

/**
 * Add notification template
 */
INSERT INTO dbs.dashboard_notifications_templates (template_name, title_En, title_Cy, description_En, description_Cy
                                                  ,notification_role, time_to_live)
VALUES ('Notice.AAA6.CP.OrderMade.Claimant', 'An order has been made', 'An order has been made',
        '<p class="govuk-body">The judge has made an order on your claim. <a href="{VIEW_FINAL_ORDER}" rel="noopener noreferrer" target="_blank" class="govuk-link">View the order</a>.</p>',
        '<p class="govuk-body">The judge has made an order on your claim. <a href="{VIEW_FINAL_ORDER}" rel="noopener noreferrer" target="_blank" class="govuk-link">View the order</a>.</p>',
        'CLAIMANT', 'Session');