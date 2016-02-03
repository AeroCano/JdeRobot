// **********************************************************************
//
// Copyright (c) 2003-2014 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `naomotions.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

(function(global, r)
{
    var require = typeof(r) === "function" ? r : function(){};
    require("Ice/Object");
    require("Ice/ObjectPrx");
    require("Ice/Operation");
    require("Ice/EnumBase");
    require("Ice/Long");
    require("Ice/HashMap");
    require("Ice/HashUtil");
    require("Ice/ArrayUtil");
    require("Ice/StreamHelpers");
    
    var Ice = global.Ice || {};
    require("common");
    
    var jderobot = global.jderobot || {};

    jderobot.MotionType = Slice.defineEnum({
        'RigthKick':0, 'LeftKick':1, 'StandupBack':2, 'StandupFront':3, 'Intercept':4,
        'ChangeCamera':5, 'ResetNaoqi':6});

    /**
     * Interface to the Nao motions
     **/
    jderobot.NaoMotions = Slice.defineObject(
        undefined,
        Ice.Object, undefined, 1,
        [
            "::Ice::Object",
            "::jderobot::NaoMotions"
        ],
        -1, undefined, undefined, false);

    jderobot.NaoMotionsPrx = Slice.defineProxy(Ice.ObjectPrx, jderobot.NaoMotions.ice_staticId, undefined);

    Slice.defineOperations(jderobot.NaoMotions, jderobot.NaoMotionsPrx,
    {
        "setMotion": [, , , , , [3], [[jderobot.MotionType.__helper]], , , , ]
    });
    global.jderobot = jderobot;
}
(typeof (global) === "undefined" ? window : global, typeof (require) === "undefined" ? undefined : require));
