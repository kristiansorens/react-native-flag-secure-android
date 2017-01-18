/* @flow */

import React, { Component } from 'react'
import { NativeModules } from 'react-native'

export default class FlagSecure extends Component {

  static isActive = false

  static activate () {
    if (!FlagSecure.isActive) {
      NativeModules.FlagSecure.activate()
      FlagSecure.isActive = true
    }
  }

  static deactivate () {
    if (FlagSecure.isActive) {
      NativeModules.FlagSecure.deactivate()
      FlagSecure.isActive = false
    }
  }

  componentWillMount () {
    FlagSecure.activate()
  }

  componentWillUnmount () {
    FlagSecure.deactivate()
  }

  render () {
    return this.props.children || null
  }
}
