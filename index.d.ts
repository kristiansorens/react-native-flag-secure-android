declare module 'react-native-flag-secure-android';
import { Component } from 'react';

export class FlagSecure extends Component {
  public static instance: FlagSecure;
  public enabled: boolean;
  public static activate: () => void;
  public static deactivate: () => void;
}

export default FlagSecure;
