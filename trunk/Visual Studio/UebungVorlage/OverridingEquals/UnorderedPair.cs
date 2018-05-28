using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OverridingEquals
{
    public class UnorderedPair : IPair
    {
        public object First { get; set; }
        public object Second { get; set; }

        public UnorderedPair(object first, object second)
        {
            First = first;
            Second = second;
        }

        protected bool Equals(UnorderedPair other)
        {
            return Equals(First, other.First) && Equals(Second, other.Second);
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != this.GetType()) return false;
            return Equals((UnorderedPair) obj);
        }

        public override int GetHashCode()
        {
            unchecked
            {
                return ((First != null ? First.GetHashCode() : 0) * 397) ^ (Second != null ? Second.GetHashCode() : 0);
            }
        }
    }
}
