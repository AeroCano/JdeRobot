SET(SOURCE_FILES recorder.cpp recordergui.cpp poolWriteImages.cpp poolWritePose3dEncoders.cpp poolWriteLasers.cpp poolWritePointCloud.cpp poolWriteEncoders.cpp RingBuffer.h RingBuffer.cpp)

add_definitions(-DGLADE_DIR="${gladedir}")

set( CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Wno-deprecated" ) # Opciones para el compilador

include_directories(
    ${INTERFACES_CPP_DIR}
    ${LIBS_DIR}/
    ${CMAKE_CURRENT_SOURCE_DIR}
    ${CMAKE_CURRENT_SOURCE_DIR}/cameras
    ${gtkmm_INCLUDE_DIRS}
    ${libglademm_INCLUDE_DIRS}
    ${gtkglextmm_INCLUDE_DIRS}
    ${easyiceconfig_INCLUDE_DIRS}
    ${resourcelocator_INCLUDE_DIRS}
)

link_directories(
	${easyiceconfig_LIBRARY_DIRS}
)

add_executable (recorder ${SOURCE_FILES})


TARGET_LINK_LIBRARIES(recorder
    ${CMAKE_THREAD_LIBS_INIT}
    ${GLUT_LIBRARIES}
    ${OpenCV_LIBRARIES}
    ${OpenCVGUI_LIBRARIES}
    ${gtkmm_LIBRARIES}
    ${libglademm_LIBRARIES}
    ${gtkglextmm_LIBRARIES}
    ${gsl_LIBRARIES}
    ${easyiceconfig_LIBRARIES} 
    ${ZeroCIce_LIBRARIES}
    ${Boost_LIBRARIES}
    colorspacesmm
    JderobotInterfaces
    jderobotutil
    logger
    ns
    ${resourcelocator_LIBRARIES}
)
