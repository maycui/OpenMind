package com.example.mayc.openmind;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;

/**
 * Created by mayc on 7/12/17.
 */
/* taken from https://github.com/watson-developer-cloud/conversation-with-discovery/blob/master/src/main/java/com/ibm/watson/apis/conversation_with_discovery/utils/Constants.java*/

/**
 * The Class Constants. This is used in DiscoveryClient
 */
public class Constants {

    private Constants() {

    }
    /** The Constant CONVERSATION_URL. */
    public static final String CONVERSATION_URL = "https://gateway.watsonplatform.net/conversation/api";

    /** The Constant CONVERSATION_VERSION. */
    public static final String CONVERSATION_VERSION = ConversationService.VERSION_DATE_2016_09_20;

    /** The Constant DISCOVERY_FIELD_BODY. */
    public static final String DISCOVERY_FIELD_BODY = "contentHtml";

    /** The Constant DISCOVERY_FIELD_CONFIDENCE. */
    public static final String DISCOVERY_FIELD_CONFIDENCE = "score";

    /** The Constant DISCOVERY_FIELD_ID. */
    public static final String DISCOVERY_FIELD_ID = "id";

    /** The Constant DISCOVERY_FIELD_SOURCE_URL. */
    public static final String DISCOVERY_FIELD_SOURCE_URL = "url";

    /** The Constant DISCOVERY_FIELD_TITLE. */
    public static final String DISCOVERY_FIELD_TITLE = "title";

    /** The Constant DISCOVERY_FIELD_AUTHOR */
    public static final String DISCOVERY_FIELD_AUTHOR = "author";

    /** The Constant DISCOVERY_FIELD_DATE*/
    public static final String DISCOVERY_FIELD_DATE = "yyyymmdd";

    /** The Constant DISCOVERY_FIELD_DESCRIPTION*/
    public static final String DISCOVERY_FIELD_DESCRIPTION = "alchemyapi_text";

    /** The Constant DISCOVERY_MAX_SEARCH_RESULTS_TO_SHOW. */
    public static final int DISCOVERY_MAX_SEARCH_RESULTS_TO_SHOW = 10;

    /**The Constant DISCOVERY_FIELD_HOST */
    public static final String DISCOVERY_FIELD_HOST = "host";

    /**The Constant DISCOVERY_FIELD_KEYWORDS */
    public static final String DISCOVERY_FIELD_KEYWORDS = "keywords";

    /** The Constant DISCOVERY_URL. */
    public static final String DISCOVERY_URL = "https://gateway.watsonplatform.net/discovery/api/";

    /** The Constant DISCOVERY_VERSION. */
    public static final String DISCOVERY_VERSION = "2016-12-15";

    /** The Constant NOT_READY. */
    public static final String NOT_READY = "not_ready";

    /** The Constant READY. */
    public static final String READY = "ready";

    // Discovery JSON object fields
    /** The Constant SCHEMA_FIELD_SOURCE_URL. */
    public static final String SCHEMA_FIELD_SOURCE_URL = "sourceUrl";

    /** The Constant SCHEMA_FIELD_TITLE. */
    public static final String SCHEMA_FIELD_TITLE = "title";

    /** The Constant SETUP_MESSAGE. */
    public static final String SETUP_MESSAGE = "setup_message";

    /** The Constant SETUP_PHASE. */
    public static final String SETUP_PHASE = "setup_phase";

    /** The Constant SETUP_STATE. */
    public static final String SETUP_STATE = "setup_state";

    /** The Constant SETUP_STATUS_MESSAGE. */
    public static final String SETUP_STATUS_MESSAGE = "setup_status_message";

    /** The Constant SETUP_STEP. */
    // Setup config JSON object Fields
    public static final String SETUP_STEP = "setup_step";

    /** The Constant WORKSPACE_ID. */
    public static final String WORKSPACE_ID = "WORKSPACE_ID";

    public static final String NAME = "Name";
    public static final String AGE = "Age";
    public static final String GENDER = "Gender";
    public static final String INCOME = "Income";
    public static final String RACE = "Race/Ethnicity";
    public static final String SEX = "Sexual Orientation";
    public static final String DISABILITY = "Are you legally disabled?";







}