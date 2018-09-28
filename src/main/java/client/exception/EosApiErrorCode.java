package client.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum EosApiErrorCode implements ErrorCode {

    UNSPECIFIED_EXCEPTION(0),
    UNHANDLED_EXCEPTION(1),
    TIMEOUT_EXCEPTION(2),
    FILE_NOT_FOUND_EXCEPTION(3),
    PARSE_ERROR_EXCEPTION(4),
    INVALID_ARG_EXCEPTION(5),
    KEY_NOT_FOUND_EXCEPTION(6),
    BAD_CAST_EXCEPTION(7),
    OUT_OF_RANGE_EXCEPTION(8),
    CANCELED_EXCEPTION(9),
    ASSERT_EXCEPTION(10),
    EOF_EXCEPTION(11),
    STD_EXCEPTION(13),
    INVALID_OPERATION_EXCEPTION(14),
    UNKNOWN_HOST_EXCEPTION(15),
    NULL_OPTIONAL(16),
    UDT_ERROR(17),
    AES_ERROR(18),
    OVERFLOW(19),
    UNDERFLOW(20),
    DIVIDE_BY_ZERO(21),
    BLOCKCHAIN_EXCEPTION(3000000),
    CHAIN_TYPE_EXCEPTION(3010000),
    INVALID_NAME(3010001),
    INVALID_PUBLIC_KEY(3010002),
    INVALID_PRIVATE_KEY(3010003),
    INVALID_AUTHORITY(3010004),
    INVALID_ACTION(3010005),
    INVALID_TRANSACTION(3010006),
    INVALID_ABI(3010007),
    NO_ABI_FOUND(3010008),
    INVALID_BLOCK_ID(3010009),
    INVALID_TRANSACTION_ID(3010010),
    INVALID_PACKED_TRANSACTION(3010011),
    INVALID_ASSET(3010012),
    FORK_DATABASE_EXCEPTION(3020000),
    UNLINKABLE_BLOCK(3020001),
    BLOCK_EXCEPTION(3030000),
    TRANSACTION_OUTPUTS_IN_BLOCK_DO_NOT_MATCH_TRANSACTION_OUTPUTS_FROM_APPLYING_BLOCK(3030001),
    BLOCK_DOES_NOT_GUARANTEE_CONCURRENT_EXECUTION_WITHOUT_CONFLICTS(3030002),
    SHARD_LOCKS_IN_BLOCK_ARE_INCORRECT_OR_MAL_FORMED(3030003),
    BLOCK_EXHAUSTED_ALLOWED_RESOURCES(3030004),
    BLOCK_IS_TOO_OLD_TO_PUSH(3030005),
    TRANSACTION_EXCEPTION(3040000),
    ERROR_DECOMPRESSING_TRANSACTION(3040001),
    TRANSACTION_SHOULD_HAVE_AT_LEAST_ONE_NORMAL_ACTION(3040002),
    TRANSACTION_SHOULD_HAVE_AT_LEAST_ONE_REQUIRED_AUTHORITY(3040003),
    CONTEXT_FREE_ACTION_SHOULD_HAVE_NO_REQUIRED_AUTHORITY(3040004),
    EXPIRED_TRANSACTION(3040005),
    TRANSACTION_EXPIRATION_TOO_FAR(3040006),
    INVALID_REFERENCE_BLOCK(3040007),
    DUPLICATE_TRANSACTION(3040008),
    DUPLICATE_DEFERRED_TRANSACTION(3040009),
    ACTION_EXCEPTION(3050000),
    ACCOUNT_NAME_ALREADY_EXISTS(3050001),
    INVALID_ACTION_ARGUMENTS(3050002),
    EOSIO_ASSERT_MESSAGE_ASSERTION_FAILURE(3050003),
    EOSIO_ASSERT_CODE_ASSERTION_FAILURE(3050004),
    DATABASE_EXCEPTION(3060000),
    PERMISSION_QUERY_EXCEPTION(3060001),
    ACCOUNT_QUERY_EXCEPTION(3060002),
    CONTRACT_TABLE_QUERY_EXCEPTION(3060003),
    CONTRACT_QUERY_EXCEPTION(3060004),
    WASM_EXCEPTION(3070000),
    ERROR_IN_WASM_PAGE_MEMORY(3070001),
    RUNTIME_ERROR_PROCESSING_WASM(3070002),
    SERIALIZATION_ERROR_PROCESSING_WASM(3070003),
    MEMCPY_WITH_OVERLAPPING_MEMORY(3070004),
    RESOURCE_EXHAUSTED_EXCEPTION(3080000),
    ACCOUNT_USING_MORE_THAN_ALLOTTED_RAM_USAGE(3080001),
    TRANSACTION_EXCEEDED_THE_CURRENT_NETWORK_USAGE_LIMIT_IMPOSED_ON_THE_TRANSACTION(3080002),
    TRANSACTION_NETWORK_USAGE_IS_TOO_MUCH_FOR_THE_REMAINING_ALLOWABLE_USAGE_OF_THE_CURRENT_BLOCK(3080003),
    TRANSACTION_EXCEEDED_THE_CURRENT_CPU_USAGE_LIMIT_IMPOSED_ON_THE_TRANSACTION(3080004),
    TRANSACTION_CPU_USAGE_IS_TOO_MUCH_FOR_THE_REMAINING_ALLOWABLE_USAGE_OF_THE_CURRENT_BLOCK(3080005),
    TRANSACTION_TOOK_TOO_LONG(3080006),
    TRANSACTION_REACHED_THE_DEADLINE_SET_DUE_TO_LEEWAY_ON_ACCOUNT_CPU_LIMITS(3081001),
    AUTHORIZATION_EXCEPTION(3090000),
    DUPLICATE_SIGNATURE_INCLUDED(3090001),
    IRRELEVANT_SIGNATURE_INCLUDED(3090002),
    PROVIDED_KEYS_PERMISSIONS_AND_DELAYS_DO_NOT_SATISFY_DECLARED_AUTHORIZATIONS(3090003),
    MISSING_REQUIRED_AUTHORITY(3090004),
    IRRELEVANT_AUTHORITY_INCLUDED(3090005),
    INSUFFICIENT_DELAY(3090006),
    MISCELLANEOUS_EXCEPTION(3100000),
    INTERNAL_STATE_IS_NO_LONGER_CONSISTENT(3100001),
    UNKNOWN_BLOCK(3100002),
    UNKNOWN_TRANSACTION(3100003),
    CORRUPTED_REVERSIBLE_BLOCK_DATABASE_WAS_FIXED(3100004),
    EXTRACTED_GENESIS_STATE_FROM_BLOCKS_LOG(3100005),
    SUBJECTIVE_EXCEPTION_THROWN_DURING_BLOCK_PRODUCTION(3100006),
    MISSING_PLUGIN_EXCEPTION(3110000),
    MISSING_CHAIN_API_PLUGIN(3110001),
    MISSING_WALLET_API_PLUGIN(3110002),
    MISSING_HISTORY_API_PLUGIN(3110003),
    MISSING_NET_API_PLUGIN(3110004),
    WALLET_EXCEPTION(3120000),
    WALLET_ALREADY_EXISTS(3120001),
    NONEXISTENT_WALLET(3120002),
    LOCKED_WALLET(3120003),
    MISSING_PUBLIC_KEY(3120004),
    INVALID_WALLET_PASSWORD(3120005),
    NO_AVAILABLE_WALLET(3120006),
    ALREADY_UNLOCKED(3120007),
    ACTOR_OR_CONTRACT_WHITELIST_BLACKLIST_EXCEPTION(3130000),
    AUTHORIZING_ACTOR_OF_TRANSACTION_IS_NOT_ON_THE_WHITELIST(3130001),
    AUTHORIZING_ACTOR_OF_TRANSACTION_IS_ON_THE_BLACKLIST(3130002),
    CONTRACT_TO_EXECUTE_IS_NOT_ON_THE_WHITELIST(3130003),
    CONTRACT_TO_EXECUTE_IS_ON_THE_BLACKLIST(3130004),
    ACTION_TO_EXECUTE_IS_ON_THE_BLACKLIST(3130005),
    PUBLIC_KEY_IN_AUTHORITY_IS_ON_THE_BLACKLIST(3130006);

    private static final Map<Integer, EosApiErrorCode> idx = new HashMap<>();

    static {
        for (EosApiErrorCode errorCode : EosApiErrorCode.values())
            idx.put(errorCode.number, errorCode);
    }

    private final int number;

    public static EosApiErrorCode get(Integer number) {
        return idx.getOrDefault(number, UNSPECIFIED_EXCEPTION);
    }

}
