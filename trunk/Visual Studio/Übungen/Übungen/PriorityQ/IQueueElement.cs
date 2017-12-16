namespace PriorityQ
{
    public interface IQueueElement
    {
        int Number { get; set; }
        int Priority { get; set; }
    }
}