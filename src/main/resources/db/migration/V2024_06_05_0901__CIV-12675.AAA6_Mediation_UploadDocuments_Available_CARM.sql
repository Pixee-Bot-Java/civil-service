/**
 * Add scenario for claimant
 */
INSERT INTO dbs.scenario (name, notifications_to_delete, notifications_to_create)
VALUES ('Scenario.AAA6.MediationUploadDocuments.ViewMediationAvailable.CARM.Claimant',
        '{"Notice.AAA6.MediationUploadDocuments.ViewMediationAvailable.CARM.Claimant"}',
        '{"Notice.AAA6.MediationUploadDocuments.ViewMediationAvailable.CARM.Claimant": []}');

/**
 * Add task list items claimant
 */
INSERT INTO dbs.task_item_template (task_name_en, category_en, task_name_cy, category_cy, template_name,
                                    scenario_name, task_status_sequence, role, task_order)

values ('<a href={VIEW_MEDIATION_DOCUMENTS} class="govuk-link">View mediation documents</a>',
        'Mediation',
        '<a href={VIEW_MEDIATION_DOCUMENTS} class="govuk-link">View mediation documents</a>',
        'Mediation', 'View.Mediation.Documents', 'Scenario.AAA6.MediationUploadDocuments.ViewMediationAvailable.CARM.Claimant', '{3, 3}', 'CLAIMANT', 7);

/**
 * Add scenario for claimant
 */
INSERT INTO dbs.scenario (name, notifications_to_delete, notifications_to_create)
VALUES ('Scenario.AAA6.MediationUploadDocuments.ViewMediationAvailable.CARM.Defendant',
        '{"Notice.AAA6.MediationUploadDocuments.ViewMediationAvailable.CARM.Defendant"}',
        '{"Notice.AAA6.MediationUploadDocuments.ViewMediationAvailable.CARM.Defendant": []}');

/**
 * Add task list items claimant
 */
INSERT INTO dbs.task_item_template (task_name_en, category_en, task_name_cy, category_cy, template_name,
                                    scenario_name, task_status_sequence, role, task_order)

values ('<a href={VIEW_MEDIATION_DOCUMENTS} class="govuk-link">View mediation documents</a>',
        'Mediation',
        '<a href={VIEW_MEDIATION_DOCUMENTS} class="govuk-link">View mediation documents</a>',
        'Mediation', 'View.Mediation.Documents', 'Scenario.AAA6.MediationUploadDocuments.ViewMediationAvailable.CARM.Defendant', '{3, 3}', 'DEFENDANT', 7);
