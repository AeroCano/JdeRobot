add_subdirectory (${CMAKE_CURRENT_SOURCE_DIR}/stable)

IF(JDEROBOT_TESTING)
	add_subdirectory (${CMAKE_CURRENT_SOURCE_DIR}/testing)
ENDIF()
