using System;
using System.ComponentModel.Design;

namespace OverridingEquals {
    public class PhoneNumber {
        // First part of a phone number: (XXX) 000-0000
        public string AreaCode { get; set; }

        // Second part of a phone number: (000) XXX-0000
        public string Exchange { get; set; }

        // Third part of a phone number: (000) 000-XXXX
        public string SubscriberNumber { get; set; }

        protected bool Equals(PhoneNumber other)
        {
            return string.Equals(AreaCode, other.AreaCode) && string.Equals(Exchange, other.Exchange) && string.Equals(SubscriberNumber, other.SubscriberNumber);
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != this.GetType()) return false;
            return Equals((PhoneNumber) obj);
        }

        public override int GetHashCode()
        {
            unchecked
            {
                var hashCode = (AreaCode != null ? AreaCode.GetHashCode() : 0);
                hashCode = (hashCode * 397) ^ (Exchange != null ? Exchange.GetHashCode() : 0);
                hashCode = (hashCode * 397) ^ (SubscriberNumber != null ? SubscriberNumber.GetHashCode() : 0);
                return hashCode;
            }
        }

        public static bool operator == (PhoneNumber a, PhoneNumber b)
        {
            if (object.ReferenceEquals(a, null))
            {
                return object.ReferenceEquals(b, null);
            }
            return a.Equals(b);
        }

        public static bool operator !=(PhoneNumber a, PhoneNumber b)
        {
            return !(a.Equals(b));
        }

        // TODO: Implement Equals 
        // TODO: Implement == and !=
        // TODO: Implement GetHashCode
    }
}