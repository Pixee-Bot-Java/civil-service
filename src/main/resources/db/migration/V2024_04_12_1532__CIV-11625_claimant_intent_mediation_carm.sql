/**
 * Add scenario for claimant
 */
INSERT INTO dbs.scenario (name, notifications_to_delete, notifications_to_create)
VALUES ('Scenario.AAA6.ClaimantIntent.Mediation.CARM.Claimant',
        '{"Notice.AAA6.DefResponse.Full Defence.FullDispute.SuggestedMediation.Claimant"}',
        '{"Notice.AAA6.ClaimantIntent.Mediation.CARM.Claimant" : []}');

/**
 * Add notification template for claimant
 */
INSERT INTO dbs.dashboard_notifications_templates ( template_name, title_En, title_Cy, description_En, description_Cy
                                                  , notification_role)
VALUES ('Notice.AAA6.ClaimantIntent.Mediation.CARM.Claimant',
        'Your claim is now going to mediation',
        'Your claim is now going to mediation',
        '<p class="govuk-body">Your claim is now going to mediation. You will be contacted within 28 days with details of your appointment. <br> If you do not attend your mediation appointment, the judge may issue a penalty.</p>',
        '<p class="govuk-body">Your claim is now going to mediation. You will be contacted within 28 days with details of your appointment. <br> If you do not attend your mediation appointment, the judge may issue a penalty.</p>',
        'CLAIMANT');

/**
 * Add scenario for defendant
 */
INSERT INTO dbs.scenario (name, notifications_to_delete, notifications_to_create)
VALUES ('Scenario.AAA6.ClaimantIntent.Mediation.CARM.Defendant',
        '{"Notice.AAA6.DefResponse.Full Defence.FullDispute.SuggestedMediation.Claimant"}',
        '{"Notice.AAA6.ClaimantIntent.Mediation.CARM.Defendant" : []}');

/**
 * Add notification template for defendant
 */
INSERT INTO dbs.dashboard_notifications_templates ( template_name, title_En, title_Cy, description_En, description_Cy
                                                  , notification_role)
VALUES ('Notice.AAA6.ClaimantIntent.Mediation.CARM.Defendant',
        'Your claim is now going to mediation',
        'Your claim is now going to mediation',
        '<p class="govuk-body">Your claim is now going to mediation. You will be contacted within 28 days with details of your appointment. <br> If you do not attend your mediation appointment, the judge may issue a penalty.</p>',
        '<p class="govuk-body">Your claim is now going to mediation. You will be contacted within 28 days with details of your appointment. <br> If you do not attend your mediation appointment, the judge may issue a penalty.</p>',
        'DEFENDANT');